
//请求地址
baseUrl='121.199.76.80:3000';

/**
 * 跳转
 * @param url
 */
function goto(url) {
        window.location.href=url;

}

/**
 * 获取URL中的信息
 * @param name
 * @returns {*}
 * @constructor
 */
function GetPar(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null){
        return decodeURIComponent(r[2]);
    }
    return null;
}


