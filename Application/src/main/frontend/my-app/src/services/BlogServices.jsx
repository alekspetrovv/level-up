import axios from 'axios';

const BLOGS_API_BASE_URL = "http://localhost:8081/blogs";

class BlogService {

    getBlogs() {
        return axios.get(BLOGS_API_BASE_URL + '/all');
    }

    createBlog(blog) {
        let data = new FormData();
        data.append('file', blog.img);
        data.append('title', blog.title);
        data.append('body', blog.body);
        const config = {
            headers: {
                'content-type': 'multipart/form-data'
            }
        }
        return axios.post(BLOGS_API_BASE_URL, data, config);
    }

    getBlogById(blogId) {
        return axios.get(BLOGS_API_BASE_URL + '/' + blogId)
    }

    updateBlog(blog, blogId) {
        let data = new FormData();
        data.append('title', blog.title);
        data.append('body', blog.body);
        data.append('file', blog.img);
        const config = {
            headers: {
                'content-type': 'multipart/form-data'
            }
        }
        return axios.put(BLOGS_API_BASE_URL + '/' + blogId, data, config);
    }

    deleteBlog(blogId) {
        return axios.delete(BLOGS_API_BASE_URL + '/' + blogId);
    }
}

export default new BlogService()