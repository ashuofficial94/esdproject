

let domain_form = document.getElementById("search_domain");

domain_form.addEventListener("submit", async (e) => {

    e.preventDefault();
    e.stopPropagation();

    document.getElementById("select_button").disabled = true;
    let domain_batch = document.getElementById("domains").value;
    let program_value = domain_batch.substring(0, domain_batch.indexOf("-"));
    let batch_value = domain_batch.substring(domain_batch.indexOf("-")+1, domain_batch.length);


    let response = await fetch('api/domains/get-courses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            program: program_value,
            batch: batch_value
        })
    });

    if(response.status === 200) {
        let data = await response.json();
        console.log(data);

        if(data.length > 0) {
            document.getElementById("courses").disabled = false;
            document.getElementById("search_button").disabled = false;
            sessionStorage.setItem('program', program_value);
            sessionStorage.setItem('batch', batch_value);

            let course_list = document.getElementById("courses");
            let str = ""

            for(let course of data) {
                str +=  "<option value = \"" + course['course_id'] + "\">" + course['name'] + " ["+ course['course_code']+"]"+"</option>"
            }
            course_list.innerHTML = str;
        }

        else {
            document.getElementById("courses").disabled = true;
            document.getElementById("search_button").disabled = true;
            sessionStorage.removeItem('program');
            sessionStorage.removeItem('batch');

            let course_list = document.getElementById("courses");
            course_list.innerHTML = "<option>No Courses available for this Domain</option>";
        }
    }

    else {
        document.getElementById("courses").disabled = true;
        document.getElementById("search_button").disabled = true;
        sessionStorage.removeItem('program');
        sessionStorage.removeItem('batch');

        let course_list = document.getElementById("courses");
        course_list.innerHTML = "<option>No Courses available for this Domain</option>";
    }

    document.getElementById("select_button").disabled = false;
});
