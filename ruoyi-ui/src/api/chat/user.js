import request from '@/utils/request'

// 查询用户余额列表
export function listUser(query) {
  return request({
    url: '/chat/user/list',
    method: 'get',
    params: query
  })
}

// 查询用户余额详细
export function getUser(id) {
  return request({
    url: '/chat/user/' + id,
    method: 'get'
  })
}

// 新增用户余额
export function addUser(data) {
  return request({
    url: '/chat/user',
    method: 'post',
    data: data
  })
}

// 修改用户余额
export function updateUser(data) {
  return request({
    url: '/chat/user',
    method: 'put',
    data: data
  })
}

// 删除用户余额
export function delUser(id) {
  return request({
    url: '/chat/user/' + id,
    method: 'delete'
  })
}
