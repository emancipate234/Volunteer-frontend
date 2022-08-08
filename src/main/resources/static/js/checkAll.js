function checkAll() {
    var volunteers = document.getElementsByName("volunteer");
    for (var i = 0;i < volunteers.length;i++) {
        volunteers[i].checked = true;
    }
}