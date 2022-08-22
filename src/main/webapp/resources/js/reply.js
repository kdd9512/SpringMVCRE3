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
            url: "/replies/" + reply.rno + ".json",
            data: JSON.stringify(reply),
            dataType: "application/json; charset=utf-8",
            success: function(xhr, status, err) {
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

    return {
        add: add,
        getList: getList,
        remove: remove,
        update: update,
        get: get
    };
})();