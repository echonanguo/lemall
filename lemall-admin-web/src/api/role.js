import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/system/role/list',
    method: 'get',
    params: params
  })
}

export function createRole(data) {
  return request({
    url: '/system/role/create',
    method: 'post',
    data: data
  })
}

export function updateRole(id, data) {
  return request({
    url: '/system/role/update/' + id,
    method: 'post',
    data: data
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/system/role/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function deleteRole(data) {
  return request({
    url:'/system/role/delete',
    method:'post',
    data:data
  })
}

export function fetchAllRoleList() {
  return request({
    url: '/system/role/listAll',
    method: 'get'
  })
}

export function listMenuByRole(roleId) {
  return request({
    url: '/system/role/listMenu/'+roleId,
    method: 'get'
  })
}

export function listResourceByRole(roleId) {
  return request({
    url: '/system/role/listResource/'+roleId,
    method: 'get'
  })
}

export function allocMenu(data) {
  return request({
    url: '/system/role/allocMenu',
    method: 'post',
    data:data
  })
}

export function allocResource(data) {
  return request({
    url: '/system/role/allocResource',
    method: 'post',
    data:data
  })
}
