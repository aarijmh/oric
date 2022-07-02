

function createALinkResearch(fileName,url){
    let tA = $('<a href=#>');

    tA.html(fileName)
    $(tA).bind('click',function(evt){
        evt.preventDefault();
        window.location.href = url+fileName;
    });

    return tA;
}

function createDLinkResearch(fileName,url,deleteCallback){
    let tA = $('<a href=#>');

    tA.html("remove")
    $(tA).bind('click',function(evt){
        evt.preventDefault();
        $.ajax({
            type : "GET",
            url : url+fileName,
            // You are expected to receive the generated JSON (json_encode($data))
            beforeSend : function(){

            },
            complete:function(){
            },
            contentType: "application/json",
            success : function(data) {
                deleteCallback(fileName);
            },
            error : function(er) {

            }
        });
    });

    return tA;
}

function createTableToShowFiles(tbody,files,showUrl,deleteUrl,deleteCallback){
    for (let i = 0; i < files.length; i++) {
        let tr = $("<tr />")
        let td1 = $("<td style='width: 80%'/>")
        $(td1).append( createALinkResearch(files[i],showUrl));
        let td2 = $("<td  style='width: 20%'/>")
        $(td2).append( createDLinkResearch(files[i],deleteUrl,deleteCallback));
        $(tr).append(td1);
        $(tr).append(td2);
        $(tbody).append(tr);
    }
}