var univ_id = "as4$$64CV23";
function initializeScroll(){
    initializeScroller("news-container_5121");
    initializeScroller("news-container_callForPaper");
    initializeScroller("news-container_consultancy");

    fetchNews(1,"sliderUL");
    fetchNews(2,"sliderULCallForPaper");
    fetchNews(3,"sliderULConsultancy");
}

function initializeScroller(div){
    let interval_63282d9d89618 = setInterval(function () {

        if (document.readyState === 'complete') {

            clearInterval(interval_63282d9d89618);
            jQuery("#"+div).css('visibility', 'visible');


            jQuery(function () {
                jQuery("#"+div).vTicker({
                    speed: 1400,
                    pause: 4000,
                    animation: '',
                    mousePause: true,
                    height: 200,
                    direction: 'up'
                });
            });


        }
    }, 100);
}

function fetchNews(type,div){
    jQuery.ajax({
        type : "GET",
        url : "/public/getPublicAnnouncement/university/as4$$64CV23/type/"+type,
        contentType: false,
        processData: false,
        // You are expected to receive the generated JSON (json_encode($data))
        beforeSend : function(){
            jQuery("#"+div).html("<li>Loading Please Wait ...... </li>");
        },
        complete:function(){
        },
        success : function(data) {
            if(data.length > 0) {
                jQuery("#"+div).empty();
                jQuery.each(data, function (k, v) {
                    jQuery("#"+div).append(handleScrollContent(v));
                });
            }
            else{
                jQuery("#"+div).html("<li>No Data Found ...... </li>");
            }


        },
        error : function(er) {

        }
    });
}

function handleScrollContent(data){
    let li = jQuery("<li style=\"margin: 0px; padding: 0px;\">");
    let div1 = jQuery("<div style=\"padding:3px\">");
    li.append(div1);

    let div2 = jQuery("<div className=\"newsscroller_title\">");
    div1.append(div2);

    let a = jQuery("<a href=\""+data.url+"\">");
    jQuery(a).html(data.title);

    div2.append(a);
    let div3 = jQuery("<div style=\"clear:both\"></div>");
    li.append(div3);

    let div4 = jQuery("<div className=\"scrollercontent\">");

    let innDiv = data.shortDescription + "<br>"+"<span style='color: darkred'>Due Date: "+data.expiryDate+"</span>"
    jQuery(div4).html(innDiv);
    li.append(div4);

    let openDiv = $("<div ><a href=\"javascript:openAd('as4$$64CV23','"+data.id+"','main_content')\">View Details</a></div>")
    li.append(openDiv);
    let div5 = jQuery("<div style=\"clear:both\"></div>");
    li.append(div5);

    return li;
}

function openAd(univ,id,div_id){
    let ajaxParams = new Object();
        ajaxParams.type = "GET";
        ajaxParams.url = "/public/getPuclicAd/university/"+univ_id+"/adId/"+id;
        ajaxParams.contentType = false;
        ajaxParams.processData = false;
        ajaxParams.data = [];
        ajaxParams.univ = univ;
        ajaxParams.succCallBackParams = new Object();
        ajaxParams.succCallBackParams.divId = div_id;
        ajaxCall(ajaxParams,displayAd,null,null,null);
}

function displayAd(ad,param){
    $("#"+param.divId).html(ad.longDescription);

    let ajaxParams = new Object();
    ajaxParams.type = "GET";
    ajaxParams.url = "/public/getPublicFiles/university/"+univ_id+"/adId/"+ad.id;
    ajaxParams.contentType = false;
    ajaxParams.processData = false;
    ajaxParams.data = [];
    ajaxParams.succCallBackParams = new Object();
    ajaxParams.succCallBackParams.adId = ad.id;
    ajaxCall(ajaxParams,listFiles,null,null,null);
}

function listFiles(files,param){
    let tab = $("<table>");
    $.each(files,function(k,v){
       let tr = $("<tr>");
       let a = "<a href='window.location.href=\"/public/openFile/univ/"+univ_id+"/adId/"+param.adId+"/fileName/"+v+"\">"+v+"</a>";
       let b = "<a href='javascript:publicOpenFile(\""+univ_id+"\","+param.adId+",\""+v+"\")'>"+v+"</a>";
       let td = $("<td>");
       $(td).html(b);
       $(tr).append(td);
       $(tab).append(tr);
    });
    $("#main_content").append(tab);
}

function publicOpenFile(univ_id,adId,fileName){
    window.location.href = "/public/openFile/univ/"+univ_id+"/adId/"+adId+"/fileName/"+fileName;pub
}