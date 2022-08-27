console.log("Reply Module Test-------------------------------");

let replyService = (function () {

    function add(reply, callback, error) {
        console.log("add reply--------------------------------------");

        $.ajax({
            type: "POST",
            url: "/replies/new",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function (result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }

    function getList(param, callback, error) {

        let bno = param.bno;
        let page = param.page || 1;

        $.getJSON("/replies/pages/" + bno + "/" + page + ".json",
            function (data) {
                if (callback) {
                    callback(data);
                }
            }
        ).fail(function (xhr, status, err) {
            if (error) {
                error();
            }
        });
    }

    function remove(rno, callback, error) {
        $.ajax({
            type: "DELETE",
            url: "/replies/" + rno,
            success: function (deleteResult, status, xhr) {
                if (callback) {
                    callback(deleteResult);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
    }

    function update(reply,callback, error) {

        console.log("RNO : " + reply.rno);

        $.ajax({
            type: "PUT",
            url: "/replies/" + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function (updateResult, status, xhr) {
                if (callback) {
                    callback(updateResult);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });

    }

    function get(rno, callback, error) {

        $.get("/replies/" + rno + ".json", function(result) {

            if (callback) {
                callback(result);
            }
        }).fail(function(xhr, status, err) {
            if (error) {
                error(err);
            }
        })

    }

    function displayTime(timeValue) {

        let today = new Date();
        let gap = today.getTime() - timeValue;

        let dateObj = new Date(timeValue);
        let str = "";

        if (gap < (1000 * 60 * 60 * 24)) {

            let hh = dateObj.getHours();
            let mi = dateObj.getMinutes();
            let ss = dateObj.getSeconds();

            return [ (hh > 9 ? '' : '0') + hh, ':',
                (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss ].join('');
        } else {

            let yy = dateObj.getFullYear();
            let mm = dateObj.getMonth() + 1; // getMonth() 는 0 부터 시작.
            let dd = dateObj.getDate();

            return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
                (dd > 9 ? '' : '0') + dd ].join('');

        }

    }

    return {
        add: add,
        getList: getList,
        remove: remove,
        update: update,
        get: get,
        displayTime: displayTime
    };
})();