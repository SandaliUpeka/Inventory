// --Refresh-------------------------------------
$(document).on("click", "#btnRefresh", function()
   {
      $("#divStsMsgItem").html("Loading...");
      $.ajax(
   {
      type : "get",
      url : "Item",
      complete : function(response, status)
    {
      onRefreshComplete(response.responseText, status);
    }
   
    });
});


function onRefreshComplete(response, status)
{
if (status == "success")
 {
 $("#divItemsTable").html(response);
 $("#divStsMsgItem").html("Loaded successfully");
 }
else if (status == "error")
 {
 $("#divStsMsgItem").html("Error while loading");
 }
else
 {
 $("#divStsMsgItem").html("Unknown error while loading");
 }
}


// --Save-------------------------------------
$(document).on("click", "#btnSave", function()
{
var validity = isValidFormItem();
if (validity == "true")
 {
 var method = "post";
 if ($("#hidItemID").val() != "0")
 {
 method = "put";
 }
 $("#divStsMsgItem").html("Saving...");
 $.ajax(
 {
 type : method,
 url : "Item",
 data : $("#formItems").serialize(),
 complete : function(response, status)
 {
 onSaveUpdateComplete(response.responseText, status);
 }
 });
 }
else
5
{
 $("#divStsMsgItem").html(validity);
 }
});
function onSaveUpdateComplete(response, status)
{
if (status == "success")
 {
 $("#formItems")[0].reset();
 $("#divItemsTable").html(response);
 $("#divStsMsgItem").html("Saved successfully");
 $("#hidItemID").val("0");
 }
else if (status == "error")
 {
 $("#divStsMsgItem").html("Error while saving");
 }
else
 {
 $("#divStsMsgItem").html("Unknown error while saving");
 }
}
// --Edit-------------------------------------------------------
$(document).on("click", "#btnEdit", function()
{
 $("#hidItemID").val($(this).data("itemid"));
 $("#txtItemName").val($(this).closest("tr").find("td:eq(1)").text());
 $("#txtItemDesc").val($(this).closest("tr").find("td:eq(2)").text());
});
// --Delete-----------------------------------------------------
$(document).on("click", "#btnRemove", function()
{
 $("#divStsMsgItem").html("Removing...");
 $.ajax(
 {
 type : "delete",
 url : "Item",
 data : "itemID=" + $(this).data("itemid"),
 complete : function(response, status)
 {
 onItemDeleteComplete(response.responseText, status);
 }
 });
});
function onItemDeleteComplete(response, status)
{
if (status == "success")
 {
 $("#divItemsTable").html(response);
 $("#divStsMsgItem").html("Removed successfully");
 }
else if (status == "error")
 {
 $("#divStsMsgItem").html("Error while removing");
 }
else
 {
 $("#divStsMsgItem").html("Unknown error while removing");
 }
}