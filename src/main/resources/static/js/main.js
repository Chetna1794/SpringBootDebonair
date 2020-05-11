$(document).ready(function () {
    var menuItems;
    $("#menu").click(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/debonair/menu",
            success: function (data) {
                menuItems = data;
                for (var i = 0; i < menuItems.length; i++) {
                    var itemSelect = `<td><input type="checkbox" id="`+ menuItems[i].itemId + `"></td>`;
                    var itemName = `<td>` + menuItems[i].itemName + `</td>`;
                    var itemPrice = `<td>Rs. ` + menuItems[i].itemRate + `</td>`;
                    var itemPrepTime = `<td>` + menuItems[i].prepTime + ` mins</td>`;
                    var menuRow = `<tr>` + itemSelect + itemName + itemPrice + itemPrepTime + `</tr>`;
                    $("#menuBody").append(menuRow);
                }
                $("#menuBody").append;
            }
        });
    });
    $("#checkStatusBtn").click(function () {
        var orderId = {
        		"orderId": $("#orderId").val()
        }
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/debonair/status",
            data: orderId,
            contentType: "application/json",
            success: function (data) {
                if (data == true) {
                    alert("Your order is getting ready!");
                } else {
                    alert("Your order not found");
                }
            }
        });
    });
    $("#checkOffersBtn").click(function () {
        var customerType = {
        		"customerType": $("#customerType1").val()
        }
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/debonair/offers",
            data: customerType,
            contentType: "application/json",
            success: function (data) {
                alert("WWoohhoo!! You can avail "+data+"% discount on your order.");
            }
        });
    });
    $("#placeOrder").click(function () {
    	
        var customerDetails = {
    	 "customerID" : $("#customerId").val(),
    	 "customerName" :  $("#customerName").val(),
         "customerDob" : $("#customerDateOfBirth").val(),
         "customerMobile" : $("#customerNumber").val(),
         "customerType" : $("#customerType").val(),
         "customerAddress" : $("#customerAddress").val()
        };
        var items = [];
        for (var i = 0; i < menuItems.length; i++) {
            var $tr = $("#menuBody").children()[i]; 
            var $td = $tr.children[0]; 
            if($td.children[0].checked) {
                    for (var j = 0; j < menuItems.length; j++) {
                        if
                            (menuItems[j].itemId == $td.children[0].id) { items.push(menuItems[j]); }
                    }
            }
        } 
        postPlacedOrder(customerDetails,items);
    }); 
    var postPlacedOrder = function (customerDetails,items) {
        var postData = {
        	"items": items,
        	"customer": customerDetails
        };
        $.ajax({
            type: "POST", url
                : "http://localhost:8080/debonair/order", data: JSON.stringify(postData), contentType: "application/json",
            success: function (data) { 
            	alert("Order Placed. \nYour bill details are:- \nBill number: " + data.billNumber +
            			"\nOrder Id: "+ data.orderId +
            			"\nTotal Amount: Rs."+ data.totalAmount); }
        });
    };
});