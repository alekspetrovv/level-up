import axios from 'axios';
const API_URL = 'http://localhost:8080/api/blogs/';

class BlogService {
  getBlogs() {
    return axios.get(API_URL + 'all');
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
    return axios.post(API_URL, data, config);
  }

  getBlogById(blogId) {
    return axios.get(API_URL + blogId)
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
    return axios.put(API_URL + blogId, data, config);
  }

  deleteBlog(blogId) {
    return axios.delete(API_URL + blogId);
  }

}

export default new BlogService();
