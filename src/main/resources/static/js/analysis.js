$("#btnRightTxt").click(function () {
    var selectedItem = $("#rightValuesTxt option:selected");
    $("#leftValuesTxt").append(selectedItem);
});

$("#btnLeftTxt").click(function () {
    var selectedItem = $("#leftValuesTxt option:selected");
    $("#rightValuesTxt").append(selectedItem);
});
