import axios from 'axios';

const USERS_API_BASE_URL = "http://localhost:8081/users";

class UserService {

    getUsers() {
        return axios.get(USERS_API_BASE_URL + '/all');
    }

    register(user) {
        let data = new FormData();
        data.append('file', user.img);
        data.append('title', blog.title);
        data.append('body', blog.body);
        const config = {
            headers: {
                'content-type': 'application/json'
            }
        }
        return axios.post(USERS_API_BASE_URL, data, config);
    }

    getUserById(userId) {
        return axios.get(USERS_API_BASE_URL + '/' + userId)
    }

    update(user, userId) {
        let data = new FormData();
        data.append('email', user.email);
        data.append('password', user.password);
        data.append('first_name', user.first_name);
        data.append('last_name', user.last_name);
        const config = {
            headers: {
                'content-type': 'multipart/form-data'
            }
        }
        return axios.put(USERS_API_BASE_URL + '/' + userId, data, config);
    }

    deleteBlog(userId) {
        return axios.delete(USERS_API_BASE_URL + '/' + userId);
    }
}

export default new UserService()