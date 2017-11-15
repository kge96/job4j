
function validate() {
    var result = true;
    var inputs = document.getElementsByClassName("user-data");
    var selects = document.getElementsByClassName("user-data-select");

    for (var i = 0; i < inputs.length; i++) {
        $(inputs[i]).removeClass("err");
        if(inputs[i].value == undefined || inputs[i].value == "") {
            $(inputs[i]).addClass("err");
            result = false;
        }
    }
    for (var i = 0; i < selects.length; i++) {
        $(selects[i]).removeClass("err");
        if(selects[i].value == undefined || selects[i].value == "") {
            $(selects[i]).addClass("err");
            result = false;
        }
    }
    return result;
}

function fillData() {
    $.ajax('./homepage', {
        method: 'get',
        complete: function (data) {
            var users = JSON.parse(data.responseText);
            var table = $(document).find(".users-personal-data")[0];

            for (var i = 0; i != users.length; i++){
                $(table).append("<tr><td>" + users[i].name + "</td>" +
                    "<td>" + users[i].login + "</td>" +
                    "<td>" + users[i].email + "</td>" +
                    "<td>" + users[i].city + "</td>" +
                    "<td>" + users[i].country + "</td>" +
                    "<td>" + users[i].role + "</td>" +
                    "<td><a href='#' onclick='false'>edit</a></td></tr>"
                );
            }
            $(document).find(".user-session").append(
                "<div class='user-name'>"+
                    "<p>User:" + "user"+ "</p>"+
                "</div>" +
                "<div class='user-role'>"+
                    "<p>Role:" + "role" + "</p>"+
                "</div>" +
                "<button onclick='signout()'>logout</button>"
            );
        },
    });
}

function checkAccess() {
    $.ajax("./auth", {
        method: 'post',
        data: {"login": document.getElementById("username").value,
               "password": document.getElementById("password").value
        },

        complete: function () {
            getAccess();
        },
        error: function (jqZHR, textStatus, errorThrow) {
            console.log("Error" + errorThrow);
        }

    });
    return false;
}
function getAccess() {
     $.ajax("./auth", {
         method: "get",
         complete: function (data) {
             var serverAnswer = JSON.parse(data.responseText);
             if (serverAnswer[0].access == "true") {
                 window.location.replace("./homepage.html");
             } else {
                 console.log("Figa");
             }
         }
     })
 }

function signout() {
    $.ajax("./signout", {
        method: "post",
        complete: function () {
            window.location.replace("./auth.html");
        }
    });
}

function addUser() {
    if (validate() == true) {
        $.ajax("./add", {
            method: "post",
            data:{
                name: document.getElementById("name").value,
                login: document.getElementById("login").value,
                password: document.getElementById("password").value,
                email: document.getElementById("email").value,
                country: document.getElementById("country").value,
                city: document.getElementById("city").value,
                role: document.getElementById("role").value
            },
            complete: function() {
                window.location.replace("./homepage.html");
            }
        });
        return false;
    } else {
        return false;
    }
}

function getCountries() {
    $.ajax("./add", {
        method: "get",
        complete: function (data) {
            var countries = JSON.parse(data.responseText);
            var select = document.getElementById("country");

            for (var i = 0; i != countries.length; i++) {
                var country = countries[i].country;
                $(select).append($('<option value=\"' +  country + '\">' + country + '</option>'));
            }
        }
    });
}

function getCities() {
    $.ajax("./refresh", {
        method: "post",
        data: {
            country: document.getElementById("country").value
        },
        complete: function (data) {
            var cities = JSON.parse(data.responseText);
            var select = document.getElementById("city");
            $(select).find("option").remove();
            for (var i = 0; i != cities.length; i++) {
                var city = cities[i].city;
                $(select).append($('<option value=\"' +  city + '\">' + city + '</option>'));
            }
        },
    });
}











