let userid = localStorage.getItem("userid")
let token = localStorage.getItem("token")

export const isTokenExpired = () => {
    if(token == null || token == undefined || token == ""){
        return false;
    }
    return true;
}

export const postRequestWithHeader = (url) => {
    return fetch("http://localhost:8080/" + url + userid,
        {
            method:"POST",
            headers:{
                'Content-Type': 'application/json',
                'user_id': userid,
                'token': token
            },
        })
}

export const postRequestWithoutHeader = (url, anObj) => {
    return fetch("http://localhost:8080/" + url,
    {
        method:"POST",
        body:JSON.stringify(anObj),
        headers:{
            'Content-Type': 'application/json'
        },
    })
}