$(document)
		.ready(
				function() {
					var menuItems;
					$("#menu")
							.click(
									function() {
										$
												.ajax({
													type : "GET",
													url : "http://localhost:8080/debonair/menu",
													success : function(data) {
														menuItems = data;
														for (var i = 0; i < menuItems.length; i++) {
															var itemSelect = `<td><input type="checkbox" id="`
																	+ menuItems[i].itemId
																	+ `"></td>`;
															var itemName = `<td>`
																	+ menuItems[i].itemName
																	+ `</td>`;
															var itemPrice = `<td>Rs. `
																	+ menuItems[i].itemRate
																	+ `</td>`;
															var itemPrepTime = `<td>`
																	+ menuItems[i].prepTime
																	+ ` mins</td>`;
															var menuRow = `<tr>`
																	+ itemSelect
																	+ itemName
																	+ itemPrice
																	+ itemPrepTime
																	+ `</tr>`;
															$("#menuBody")
																	.append(
																			menuRow);
														}
														$("#menuBody").append
														console
																.log(JSON
																		.parse(this.response));
													}
												});
									});
					$("#checkStatusBtn").click(function() {
						var orderId = $("#orderId").val();
						$.ajax({
							type : "POST",
							url : "http://localhost:8080/debonair/status",
							data : orderId,
							contentType : "application/json",
							success : function(data) {
								if (data == true) {
									alert("Your order is getting ready!");
								} else {
									alert("Your order not found");
								}
							}
						});
					});
					$("#checkOffersBtn")
							.click(
									function() {
										var orderId = $("#customerId").val();
										$
												.ajax({
													type : "POST",
													url : "http://localhost:8080/debonair/offers",
													data : orderId,
													contentType : "application/json",
													success : function(data) {
														if (data === "CORPORATE") {
															alert("Hurray!! 25% off on complete bill.");
														} else if (data === "REGULAR") {
															alert("Yippee!! 15% off on complete bill.")
														}
													}
												});
									});
					$("#placeOrder")
							.click(
									function() {
										var items = [];
										for (var i = 0; i < menuItems.length; i++) {
											var $tr = $("#menuBody").children()[i];
											var $td = $tr.children[0];
											if ($td.children[0].checked) {
												for (var j = 0; j < menuItems.length; j++) {
													if (menuItems[j].itemId == $td.children[0].id) {
														items
																.push(menuItems[j]);
													}
												}
											}
										}
										postPlacedOrder(items);
									});
					var postPlacedOrder = function(itemIds) {
						var postData = itemIds;
						$.ajax({
							type : "POST",
							url : "http://localhost:8080/debonair/order",
							data : JSON.stringify(itemIds),
							contentType : "application/json",
							success : function() {
								alert("Order Placed");
							}
						});

					};
				});