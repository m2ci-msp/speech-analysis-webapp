$("#btnRightTxt").click(function () {
    var selectedItem = $("#rightValuesTxt option:selected");
    $("#leftValuesTxt").append(selectedItem);
});

$("#btnLeftTxt").click(function () {
    var selectedItem = $("#leftValuesTxt option:selected");
    $("#rightValuesTxt").append(selectedItem);
});

$("#btnRightVoice").click(function () {
    var selectedItem = $("#rightValuesVoice option:selected");
    $("#leftValuesVoice").append(selectedItem);
});

$("#btnLeftVoice").click(function () {
    var selectedItem = $("#leftValuesVoice option:selected");
    $("#rightValuesVoice").append(selectedItem);
});