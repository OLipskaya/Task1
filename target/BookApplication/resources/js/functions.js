
Id = {
    KEY: "input-key",
    RES: "input-res",
    VIEW1: "var1",
    VIEW2: "var2",
    SPAN1: "error1",
    SPAN2: "error2",
    SPAN3: "error-label"
}

Message = {
    MKEY: "type the keyword: ",
    MVIEW: "select on / off:",
    MANSWER: "keyword does not exist",
    OUTON: "I am turned on",
    OUTOFF: "I am turned off",
    ON: "on", OFF: "off"
}

function validate(){
    var keyWord = document.getElementById(Id.KEY).value;
    var view1 = document.getElementById(Id.VIEW1);
    var view2 = document.getElementById(Id.VIEW2);
    var check = true;
    if(keyWord.length==0){
        document.getElementById(Id.SPAN1).innerHTML=Message.MKEY;
        check = false;
    }
    if((!view1.checked) && (!view2.checked)){
        document.getElementById(Id.SPAN2).innerHTML=Message.MVIEW;
        check = false;
    }
    if(check){
        var view;
        if(view1.checked == true){ view = Message.ON; }
        else if(view2.checked == true){ view = Message.OFF; }
        reqst(keyWord, view);
    }
}

function forward(keyword, views){
    var DEV = { key: keyword, view: views }
    var device = JSON.stringify(DEV);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", '/ControlServlet', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(device);
}

function result(){
    var xhr1 = new XMLHttpRequest();
    xhr1.open("GET", '/ControlServlet', true);
    xhr1.send();
    var message = xhr1.responseText;
    document.getElementById(Id.RES).value = message;
    if(message=="error"){
        document.getElementById(Id.SPAN3).innerHTML=Message.MANSWER;
    }
}

function reqst(keyWord, view) {
    var xhr1 = new XMLHttpRequest();
    xhr1.open("GET", '/ControlServlet?key='+keyWord+'&view='+view, false);
    xhr1.send(null);
    if(xhr1.status == 200){
        var message = xhr1.responseText;
        document.getElementById(Id.RES).value = message;
    }
}
