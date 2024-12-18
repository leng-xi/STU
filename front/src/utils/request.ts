import axios from "axios"
import store from '@/store'
const request = axios.create({
    baseURL: "http://172.16.0.161:8080"
})
request.interceptors.request.use(
    (config) => {
      // 从 localStorage 获取 token
      const token = store.state.jwt
      if (token) {  
        config.headers['token'] = token;
      }
      return config;
    },
    (error) => {
      return Promise.reject(error);
    }
  );
  
  export default request;