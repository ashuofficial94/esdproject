let login_form = document.getElementById('login_form')

login_form.addEventListener("submit", async (e) => {
    e.preventDefault();
    e.stopPropagation();

    document.getElementById('submit-button').disabled = true;

    if(login_form.checkValidity() == true) {

        let response = await fetch('api/employees/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value
            })
        });

        if(response.status === 200) {

            let data = await response.json();
            sessionStorage.setItem('id', data["employee_id"]);
            sessionStorage.setItem('name', data["first_name"]);

            location.href = "dashboard.jsp";
        }

        else {
            document.getElementById("login-alert").style.display = "block";
        }

        document.getElementById('submit-button').disabled = false;
    }
});