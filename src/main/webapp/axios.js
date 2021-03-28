import axios from 'axios'

axios.defaults.baseURL = "http://localhost:8080/"

//ǰ������
axios.interceptors.request.use(config => {

    return config





}),
    //��������
axios.interceptors.response.use(response => {




})