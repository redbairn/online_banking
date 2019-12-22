$(document).ready(function () {

    // On page load: datatable
    var table_transactions = $('#table_transactions').DataTable({
        processing: true,
        ajax: {url: "api/transactions", dataSrc: ""},
        "columns": [
            {"data": "dateAdded",
                "render": function (data) {
                    var date = new Date(data);
                    var month = date.getMonth() + 1;
                    return date.getDate() + "/" + (month.toString().length > 1 ? month : "0" + month) + "/" + date.getFullYear();
                }
            },
            {"data": "description"},
            {"data": "accountNo"},
            {"data": "debitAmount"},
            {"data": "creditAmount"},
            {"data": "balance"}
        ],
        "aoColumnDefs": [
            {"bSortable": false, "aTargets": [-1]}
        ],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
        "oLanguage": {
            "oPaginate": {
                "sFirst": " ",
                "sPrevious": " ",
                "sNext": " ",
                "sLast": " "
            },
            "sLengthMenu": "Records per page: _MENU_",
            "sInfo": "Total of _TOTAL_ records (showing _START_ to _END_)",
            "sInfoFiltered": "(filtered from _MAX_ total records)"
        }
    });

    // On page load: form validation
    jQuery.validator.setDefaults({
        success: 'valid',
        errorPlacement: function (error, element) {
            error.insertBefore(element);
        },
        highlight: function (element) {
            $(element).parent('.field_container').removeClass('valid').addClass('error');
        },
        unhighlight: function (element) {
            $(element).parent('.field_container').addClass('valid').removeClass('error');
        }
    });
    var form_transaction = $('#form_transaction');
    form_transaction.validate();

    // Show message
    function show_message(message_text, message_type) {
        $('#message').html('<p>' + message_text + '</p>').attr('class', message_type);
        $('#message_container').show();
        if (typeof timeout_message !== 'undefined') {
            window.clearTimeout(timeout_message);
        }
        timeout_message = setTimeout(function () {
            hide_message();
        }, 8000);
    }
    // Hide message
    function hide_message() {
        $('#message').html('').attr('class', '');
        $('#message_container').hide();
    }

    // Show loading message
    function show_loading_message() {
        $('#loading_container').show();
    }
    // Hide loading message
    function hide_loading_message() {
        $('#loading_container').hide();
    }

    // Show lightbox
    function show_lightbox() {
        $('.lightbox_bg').show();
        $('.lightbox_container').show();
    }
    // Hide lightbox
    function hide_lightbox() {
        $('.lightbox_bg').hide();
        $('.lightbox_container').hide();
    }
    // Lightbox background
    $(document).on('click', '.lightbox_bg', function () {
        hide_lightbox();
    });
    // Lightbox close button
    $(document).on('click', '.lightbox_close', function () {
        hide_lightbox();
    });
    // Escape keyboard key
    $(document).keyup(function (e) {
        if (e.keyCode == 27) {
            hide_lightbox();
        }
    });

    // Hide iPad keyboard
    function hide_ipad_keyboard() {
        document.activeElement.blur();
        $('input').blur();
    }
        // Create Account - button
    $(document).on('click', '#create_account', function (e) {
        e.preventDefault();
        $('.lightbox_content h2').text('Create Account');
        $('#form_transaction button').text('Create Account');
        $('#form_transaction').attr('class', 'form add');
        $('#form_transaction').attr('data-id', '');
        $('#form_transaction .field_container label.error').hide();
        $('#form_transaction .field_container').removeClass('valid').removeClass('error');
        $('#form_transaction #amount').val('');
        $('#form_transaction #accountNo').val('');
        show_lightbox();
    });

    $(document).on('submit', '#form_transaction.add', function (e) {
        e.preventDefault();
        // Validate form
        if (form_transaction.valid() == true) {
            hide_ipad_keyboard();
            hide_lightbox();
            show_loading_message();
            var form_data = $('#form_transaction').serializeJSON();
            var request = $.ajax({
                url: 'api/transaction/',
                cache: false,
                processData: false,
                data: form_data,
                dataType: 'json',
                contentType: 'application/json',
                type: 'post'
            });
            request.done(function (output) {
                $('#table_transactions').dataTable().api().ajax.reload(function () {
                    hide_loading_message();
                    var accountNo = $('#accountNo').val();
                    show_message("Account Successfully created - " + accountNo + ".", 'success');
                }, true);
            });

            request.fail(function (jqXHR, textStatus) {
                hide_loading_message();
                show_message('Add request failed: ' + textStatus, 'error');
            });
        }
    });
    // Make Lodgement - button
    $(document).on('click', '#make_lodgement', function (e) {
        e.preventDefault();
        $('.lightbox_content h2').text('Make Lodgement');
        $('#form_transaction button').text('Lodgement');
        $('#form_transaction').attr('class', 'form add');
        $('#form_transaction').attr('data-id', '');
        $('#form_transaction .field_container label.error').hide();
        $('#form_transaction .field_container').removeClass('valid').removeClass('error');
        $('#form_transaction #amount').val('');
        $('#form_transaction #accountNo').val('');
        show_lightbox();
    });

    $(document).on('submit', '#form_transaction.add', function (e) {
        e.preventDefault();
        // Validate form
        if (form_transaction.valid() == true) {
            hide_ipad_keyboard();
            hide_lightbox();
            show_loading_message();
            var form_data = $('#form_transaction').serializeJSON();
            var request = $.ajax({
                url: 'api/transaction/',
                cache: false,
                processData: false,
                data: form_data,
                dataType: 'json',
                contentType: 'application/json',
                type: 'post'
            });
            request.done(function (output) {
                $('#table_transactions').dataTable().api().ajax.reload(function () {
                    hide_loading_message();
                    var accountNo = $('#accountNo').val();
                    show_message("Lodgement processed successfully for account no - " + accountNo + ".", 'success');
                }, true);
            });

            request.fail(function (jqXHR, textStatus) {
                hide_loading_message();
                show_message('Add request failed: ' + textStatus, 'error');
            });
        }
    });

    // Make Withdrawal - button
    $(document).on('click', '#make_withdrawal', function (e) {
        e.preventDefault();
        $('.lightbox_content h2').text('Make Withdrawal');
        $('#form_transaction button').text('Withdrawal');
        $('#form_transaction').attr('class', 'form add');
        $('#form_transaction').attr('data-id', '');
        $('#fform_transaction .field_container label.error').hide();
        $('#form_transaction .field_container').removeClass('valid').removeClass('error');
        $('#form_transaction #amount').val('');
        $('#form_transaction #accountNo').val('');
        show_lightbox();
    });

    $(document).on('submit', '#form_withdrawal.add', function (e) {
        e.preventDefault();
        // Validate form
        if (form_transaction.valid() == true) {
            hide_ipad_keyboard();
            hide_lightbox();
            show_loading_message();
            var form_data = $('#form_withdrawal').serializeJSON();
            var request = $.ajax({
                url: 'api/transaction/',
                cache: false,
                processData: false,
                data: form_data,
                dataType: 'json',
                contentType: 'application/json',
                type: 'post'
            });
            request.done(function (output) {
                $('#table_transactions').dataTable().api().ajax.reload(function () {
                    hide_loading_message();
                    var accountNo = $('#accountNo').val();
                    show_message("Withdrawal processed successfully for account no - " + accountNo + ".", 'success');
                }, true);
            });

            request.fail(function (jqXHR, textStatus) {
                hide_loading_message();
                show_message('Add request failed: ' + textStatus, 'error');
            });
        }
    });
//        // Make Transfer - button
//    $(document).on('click', '#make_transfer', function (e) {
//        e.preventDefault();
//        $('.lightbox_content h2').text('Make Transfer');
//        $('#form_transaction button').text('Transfer ');
//        $('#form_transaction').attr('class', 'form add');
//        $('#form_transaction').attr('data-id', '');
//        $('#form_transaction .field_container label.error').hide();
//        $('#form_transaction .field_container').removeClass('valid').removeClass('error');
//        $('#form_transaction #amount').val('');
//        $('#form_transaction #accountNo').val('');
//        show_lightbox();
//    });
//
//    $(document).on('submit', '#form_transaction.add', function (e) {
//        e.preventDefault();
//        // Validate form
//        if (form_transaction.valid() == true) {
//            hide_ipad_keyboard();
//            hide_lightbox();
//            show_loading_message();
//            var form_data = $('#form_transaction').serializeJSON();
//            var request = $.ajax({
//                url: 'api/transaction/',
//                cache: false,
//                processData: false,
//                data: form_data,
//                dataType: 'json',
//                contentType: 'application/json',
//                type: 'post'
//            });
//            request.done(function (output) {
//                $('#table_transactions').dataTable().api().ajax.reload(function () {
//                    hide_loading_message();
//                    var accountNo = $('#accountNo').val();
//                    show_message("Transfer processed successfully for account no - " + accountNo + ".", 'success');
//                }, true);
//            });
//
//            request.fail(function (jqXHR, textStatus) {
//                hide_loading_message();
//                show_message('Add request failed: ' + textStatus, 'error');
//            });
//        }
//    });
});