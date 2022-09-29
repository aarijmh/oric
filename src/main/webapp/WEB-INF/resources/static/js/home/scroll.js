var univ_id = "as4$$64CV23";

function initializeScroll() {
    fetchNews(1, "fundinglist");
    fetchNews(2, "paperlist");
    fetchNews(5, "workshoplist");
    fetchNews(4, "internshiplist");
    fetchNews(3, "consultancylist");
}

function initializeScroller(div) {
    $("#" + div).newslist({"cycleSpeed": 2000});
}

function fetchNews(type, div) {
    jQuery.ajax({
        type: "GET",
        url: "/public/getPublicAnnouncement/university/as4$$64CV23/type/" + type,
        contentType: false,
        processData: false,
        // You are expected to receive the generated JSON (json_encode($data))
        beforeSend: function () {
            jQuery("#" + div+"Items").html("<li>Loading Please Wait ...... </li>");
        },
        complete: function () {
        },
        success: function (data) {
            if (data.length > 0) {
                jQuery("#" + div+"Items").empty();
                jQuery.each(data, function (k, v) {
                    if (v != null)
                        $("#" + div+"Items").append(handleScrollContent(v) );
                });
            } else {
                jQuery("#" + div+"Items").html("<li>No Data Found ...... </li>");
            }
            initializeScroller(div);


        },
        error: function (er) {

        }
    });
}

function handleScrollContent(data) {

    let div = $("<div class=\"item\">")
    let div1 = $("<div><a href=\"javascript:openAd('as4$$64CV23','"+data.id+"','main_content')\">"+data.title+"</a></div>");
    $(div).append(div1);
    if(data.expiryDate != null) {
        let div2 = $("<div style='color: darkred'> Due Date : " + data.expiryDate + "</div>");
        $(div).append(div2);
    }


    return div;
}

function openAd(univ, id, div_id) {
    let ajaxParams = new Object();
    ajaxParams.type = "GET";
    ajaxParams.url = "/public/getPuclicAd/university/" + univ_id + "/adId/" + id;
    ajaxParams.contentType = false;
    ajaxParams.processData = false;
    ajaxParams.data = [];
    ajaxParams.univ = univ;
    ajaxParams.succCallBackParams = new Object();
    ajaxParams.succCallBackParams.divId = div_id;
    ajaxCall(ajaxParams, displayAd, null, null, null);
}

function displayAd(ad, param) {
    $("#" + param.divId).html("<b>" + ad.title + "</b><br></br>" + ad.longDescription);

    let ajaxParams = new Object();
    ajaxParams.type = "GET";
    ajaxParams.url = "/public/getPublicFiles/university/" + univ_id + "/adId/" + ad.id;
    ajaxParams.contentType = false;
    ajaxParams.processData = false;
    ajaxParams.data = [];
    ajaxParams.succCallBackParams = new Object();
    ajaxParams.succCallBackParams.adId = ad.id;
    ajaxCall(ajaxParams, listFiles, null, null, null);
}

function listFiles(files, param) {
    let tab = $("<table>");
    $.each(files, function (k, v) {
        let tr = $("<tr>");
        let a = "<a href='window.location.href=\"/public/openFile/univ/" + univ_id + "/adId/" + param.adId + "/fileName/" + v + "\">" + v + "</a>";
        let b = "<a href='javascript:publicOpenFile(\"" + univ_id + "\"," + param.adId + ",\"" + v + "\")'>" + v + "</a>";
        let td = $("<td>");
        $(td).html(b);
        $(tr).append(td);
        $(tab).append(tr);
    });
    $("#main_content").append(tab);
}

function publicOpenFile(univ_id, adId, fileName) {
    window.location.href = "/public/openFile/univ/" + univ_id + "/adId/" + adId + "/fileName/" + fileName;
    pub
}