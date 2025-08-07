import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/system/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo() {
  return request({
    url: '/system/info',
    method: 'get',
  })
}

export function logout() {
  return request({
    url: '/system/logout',
    method: 'post'
  })
}

export function fetchList(params) {
  return request({
    url: '/system/list',
    method: 'get',
    params: params
  })
}

export function createAdmin(data) {
  return request({
    url: '/system/register',
    method: 'post',
    data: data
  })
}

export function updateAdmin(id, data) {
  return request({
    url: '/system/update/' + id,
    method: 'post',
    data: data
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/system/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function deleteAdmin(id) {
  return request({
    url: '/system/delete/' + id,
    method: 'post'
  })
}

export function getRoleByAdmin(id) {
  return request({
    url: '/system/role/' + id,
    method: 'get'
  })
}

export function allocRole(data) {
  return request({
    url: '/system/role/update',
    method: 'post',
    data: data
  })
}
