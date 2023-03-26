const form = document.getElementById("form");

form.querySelectorAll("input").forEach(e => {
    if(e.dataset.hasOwnProperty('oldvalue')) e.value = e.dataset.oldvalue
})
form.querySelectorAll("textarea").forEach(e => {
    if(e.dataset.hasOwnProperty('oldvalue')) e.innerText = e.dataset.oldvalue
})

const messageError = {
	"required" : "Campo obligatorio.",
	"regex" : "Campo inválido."
};

form.addEventListener("submit", e => {

    form.querySelectorAll("[required]").forEach(n => {
        if(!n.value.trim()){
            n.classList.remove("is-valid")
            n.classList.add("is-invalid");
            n.parentElement.querySelector(".invalid-feedback").innerText = messageError["required"]
            e.preventDefault();
            e.stopPropagation();
        }else{
            n.classList.remove("is-invalid")
            n.classList.add("is-valid")
        }
    });

    form.querySelectorAll(".regex-check").forEach(n => {

        if(!(new RegExp(n.dataset.regex).test(n.value))){
            n.classList.remove("is-valid")
            n.classList.add("is-invalid");
            e.preventDefault();
            e.stopPropagation();
        }else{
            n.classList.remove("is-invalid")
            n.classList.add("is-valid")
        }

    })

});