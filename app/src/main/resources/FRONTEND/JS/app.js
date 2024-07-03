const menu = document.getElementById("options");
const btn = document.getElementById("menu__icon");
let isActive = false;

function deploy() {
    if(!isActive){
        menu.style.animation = "1s 1 deploy normal";
        menu.style.width = "100%";
        menu.style.height = "100%";
        document.querySelector("html").style.overflow = "hidden";
        isActive = true;
    }else{
        menu.style.animation = "1s 1 undeploy";
        menu.style.width = "0%";
        menu.style.height = "0%";
        document.querySelector("html").style.overflow = "scroll";
        isActive = false;
    }
}

function redirect(route){
    return location.href = route;
}