if (!_data) {
    var _data = {};
}

_data.formData = {};
_data.subscribeTo = [];
decodeURIComponent(location.search).replace(/^\?/, '').split('&').forEach(function (e) {
    var temp;
    temp = e.split('=');
    if (temp[0].indexOf('field_') == 0) {
        _data.formData[temp[0]] = temp[1];
    } else if (temp[0].indexOf('d') == 0) {
        _data.subscribeTo.push(temp[0])
    }
});
_data.subscribeTo.push('default');
var username = [
    ', ',
    _data.formData.field_name_first,
    _data.formData.field_name_mid
].join(' ').replace(/\s{2,}/g, ' ');

$($("#userName")).ready(function () {
    if (username.length > 2) $('#userName').text(username);
});