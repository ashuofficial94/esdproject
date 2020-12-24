
let domain_form = document.getElementById("domain-form");

domain_form.addEventListener("submit", async (e) => {

    e.preventDefault();
    e.stopPropagation();

    let submit_button = document.getElementById("submit-button");
    submit_button.disabled = true;
    submit_button.innerHTML = "Adding..";

    let form_data = new FormData();
    form_data.append('batch', document.getElementById('batch').value);
    form_data.append('capacity', document.getElementById('capacity').value);
    form_data.append('program', document.getElementById('program').value);
    form_data.append('qualification', document.getElementById('qualification').value);

    console.log(form_data);

    let response = await fetch("api/domains/add-domain", {
        method: 'POST',
        body: form_data
    });

    let result = await response;
    let notification = document.getElementById("notification");
    notification.style.display = "block";

    if(result.status === 200) {
        notification.classList.remove("alert-warning");
        notification.classList.add("alert-success");
        notification.innerHTML = "Domain Added";
    }
    else {
        notification.classList.remove("alert-success");
        notification.classList.add("alert-warning");
        notification.innerHTML = "Program (" + document.getElementById("program").value + " - " +
            document.getElementById("batch").value + ") already present.";
    }

    submit_button.disabled = false;
    submit_button.innerHTML = "Add";
});