function change() {
    var myselect = document.getElementById("select");
    var index = myselect.selectedIndex;
    if(myselect.options[index].value === "类型") {
        document.getElementById("year").style.display = "inline-block";
        document.getElementById("star").style.display = "none";
        document.getElementById("type").style.display = "inline-block";
        document.getElementById("number").style.display = "none";
    }else if(myselect.options[index].value === "星级") {
        document.getElementById("year").style.display = "inline-block";
        document.getElementById("star").style.display = "inline-block";
        document.getElementById("type").style.display = "none";
        document.getElementById("number").style.display = "none";
    } else if(myselect.options[index].value === "学号") {
        document.getElementById("year").style.display = "none";
        document.getElementById("star").style.display = "none";
        document.getElementById("type").style.display = "none";
        document.getElementById("number").style.display = "inline-block";
    }
}