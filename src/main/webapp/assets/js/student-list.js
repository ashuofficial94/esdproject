let search_button = document.getElementById("search_button");

search_button.addEventListener("click", async (e) =>  {

    e.preventDefault();
    e.stopPropagation();

    search_button.disabled = true;

    let response = await fetch('api/courses/get-students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            course_id: document.getElementById("courses").value
        })
    });

    if(response.status === 200) {
        let data = await response.json();
        console.log(data);
        let student_table = document.getElementById("student-table");
        student_table.innerHTML = "";
        let course_id = document.getElementById("courses").value;

        for (let student of data) {

            let student_obj = {
                student_id: student['student_id']
            }
            let course_obj = {
                course_id: course_id
            }

            let response = await fetch('api/grades/student-grade', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    student_id: student_obj,
                    course_id: course_obj
                })
            });

            let grade = "";

            if (response.status === 200) {
                let grade_data = await response.json();
                grade = grade_data['letter_grade'];
            }

            response = await fetch('api/grades/get-grades', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                }
            });

            let grade_data = await response.json();
            let row = document.createElement("TR");

            let col1 = document.createElement("TD");
            let text1 = document.createTextNode(student['roll_number']);
            col1.appendChild(text1);

            let col2 = document.createElement("TD");
            let text2 = document.createTextNode(student['first_name']);
            col2.appendChild(text2);

            let col3 = document.createElement("TD");
            let text3 = document.createTextNode(grade);
            col3.setAttribute("id", "grade_id"+student["student_id"]);
            col3.appendChild(text3);

            let col4 = document.createElement("TD");
            let select = document.createElement("SELECT");
            select.setAttribute("id", "change-grade"+student['student_id']);
            select.setAttribute("class", "form-control");
            select.setAttribute("onchange",
                "(changeGrade(\""+student['student_id']+"\",\""+course_id+"\"))()");

            let option = document.createElement("OPTION");
            option.setAttribute("disabled", "true");
            option.setAttribute("selected", "true");
            option.setAttribute("value", "");

            let text = document.createTextNode("Change Grade");
            option.appendChild(text);
            select.appendChild(option);

            for(let grade of grade_data) {
                let option = document.createElement("OPTION");
                option.setAttribute("value", grade['grade_id']);
                let text = document.createTextNode(grade['letter_grade']);
                option.appendChild(text);
                select.appendChild(option)
            }

            option = document.createElement("OPTION");
            option.setAttribute("value", "100");
            text = document.createTextNode("Not Graded");
            option.appendChild(text);
            select.appendChild(option);

            col4.appendChild(select);

            row.appendChild(col1);
            row.appendChild(col2);
            row.appendChild(col3);
            row.appendChild(col4);

            student_table.appendChild(row);
        }
    }
    document.getElementById('search_button').disabled = false;
});

async function changeGrade(student_id, course_id) {

    let grade_id = document.getElementById("change-grade"+student_id).value;

    let form_data = new FormData();
    form_data.append('student_id', student_id);
    form_data.append('course_id', course_id);
    form_data.append('grade_id', grade_id);


    let response = await fetch ('api/grades/change', {
        method: 'POST',
        body: form_data
    });

    let data = await response.json();

    let grade = document.getElementById("grade_id"+student_id);
    grade.innerText = data['letter_grade'];
}