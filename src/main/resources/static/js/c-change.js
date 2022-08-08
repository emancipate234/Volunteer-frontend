function selectchange() {
    var myselect = document.getElementById("select");
    var index = myselect.selectedIndex;
    if(myselect.options[index].value === "类型") {
        document.getElementById("year").style.display = "inline-block";
        document.getElementById("star").style.display = "none";
        document.getElementById("type").style.display = "inline-block";
        document.getElementById("number").style.display = "none";
        document.getElementById("rise").style.display = "inline-block";
        document.getElementById("v-add").style.display = "none";
        var type = document.getElementById("type");
        type.value = "普通志愿者";
    }else if(myselect.options[index].value === "星级") {
        document.getElementById("year").style.display = "inline-block";
        document.getElementById("star").style.display = "inline-block";
        document.getElementById("type").style.display = "none";
        document.getElementById("number").style.display = "none";
        document.getElementById("rise").style.display = "inline-block";
        document.getElementById("v-add").style.display = "none";
    } else if(myselect.options[index].value === "学号") {
        document.getElementById("year").style.display = "none";
        document.getElementById("star").style.display = "none";
        document.getElementById("type").style.display = "none";
        document.getElementById("number").style.display = "inline-block";
        document.getElementById("rise").style.display = "inline-block";
        document.getElementById("v-add").style.display = "none";
    }
}
function typechange() {
    var type = document.getElementById("type");
    var index = type.selectedIndex;
    if(type.options[index].value === "优秀青年志愿者") {
        document.getElementById("v-add").style.display = "inline-block";
        document.getElementById("rise").style.display = "none";
    } else {
        document.getElementById("v-add").style.display = "none";
        document.getElementById("rise").style.display = "inline-block";
    }
}