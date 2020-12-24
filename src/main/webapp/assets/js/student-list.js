
let student_list = document.getElementById("student-list");
let course_form = document.getElementById("search_course");

course_form.addEventListener("submit", async (e) => {

    e.preventDefault();
    e.stopPropagation();

    document.getElementById("search_button").disabled = true;

    if(course_form.checkValidity() == true) {

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
            let student_table = document.getElementById("student-table");
            let course_id = document.getElementById("courses").value;

            let str = "";

            for(let student of data) {
                str += "<tr>" +
                    "<td>" + student['student_id'] + "</td>" +
                    "<td>" + student['first_name'] + "</td>" +
                    "<td>" + course_id + "</td>" +
                    "<td></td><td></td>" +
                    "</tr>";
            }

            student_table.innerHTML = str;
        }

        document.getElementById('search_button').disabled = false;
    }
});


