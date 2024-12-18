import request from "../utils/request.ts";
export const getTeacherList = (jwt) =>{
    return request({
        method:'GET',
        url:'/teacher/getTeacherList',
        headers: {
            token: jwt// 添加认证头
          },
    })
}