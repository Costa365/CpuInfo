$(document).ready(function () {
    $('#view-details-button').on('click', viewInfo);	
});

$(document).keypress(function(e) {
    if(e.which == 13) {
		e.preventDefault();
        $("#view-details-button").click();
    }
});

function viewInfo() {
    var cpuName = $('#cpu-name').val();
    showBusyCursor(true);
    clearInfo();
    document.getElementById("cpu-info-results").style.display = "block";
    var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var data = this.responseText;
            var jsonResponse = JSON.parse(data);
            if(Object.keys(jsonResponse).length > 0) {
                document.getElementById("cpuname").innerHTML = jsonResponse[0]["name"];
                document.getElementById("cpucores").innerHTML = jsonResponse[0]["cores"];
                document.getElementById("cputype").innerHTML = jsonResponse[0]["type"];
                document.getElementById("cpumark").innerHTML = jsonResponse[0]["cpuMark"];
                document.getElementById("cpusingle").innerHTML = jsonResponse[0]["singleThreadMark"];
                document.getElementById("cputdp").innerHTML = jsonResponse[0]["tdp"];
                document.getElementById("cpuperf").innerHTML = jsonResponse[0]["powerPerf"];
                document.getElementById("cpureleasedate").innerHTML = jsonResponse[0]["releaseDate"];
            }
            showBusyCursor(false);
        }
    };
    xhttp.open('GET', 'http://costa365.pserver.ru:8080/cpus/search?name=' + cpuName, true);
    xhttp.send();
}

function clearInfo() {
    document.getElementById("cpuname").innerHTML = ".";
    document.getElementById("cpucores").innerHTML = ".";
    document.getElementById("cputype").innerHTML = ".";
    document.getElementById("cpumark").innerHTML = ".";
    document.getElementById("cpusingle").innerHTML = ".";
    document.getElementById("cputdp").innerHTML = ".";
    document.getElementById("cpuperf").innerHTML = ".";
    document.getElementById("cpureleasedate").innerHTML = ".";
}

function showBusyCursor(busy) {
    cursorType = "default";
    if (busy === true) {
        cursorType = "progress";
    }
    $("body").css("cursor", cursorType);
    $("#view-details-button").css("cursor", cursorType);
    $("#cpu-name").css("cursor", cursorType);
}
