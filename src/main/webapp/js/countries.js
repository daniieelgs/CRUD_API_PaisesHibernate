document.querySelectorAll(".country-link").forEach(n => n.addEventListener("click", () => window.location.href = n.dataset.link));

const modalElemet = document.getElementById('modalDelete');

let modal = null;

if(modalElemet){
    modal = new bootstrap.Modal(document.getElementById('modalDelete'));

    modalElemet.querySelector(".btn-delete").addEventListener("click", () => modal.hide());
}

document.querySelectorAll(".delete-country").forEach(n => n.addEventListener("click", () => {

    modalElemet.querySelector(".country-name").innerText = n.dataset.countryname;

    modalElemet.querySelector(".form-delete").action = `/HibernateApp/Country/${n.dataset.countryid}/delete`;

    modal.show();
}));