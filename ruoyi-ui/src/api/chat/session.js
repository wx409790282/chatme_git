import request from '@/utils/request'

// 查询会话列表
export function listSession(query) {
  return request({
    url: '/chat/session/list',
    method: 'get',
    params: query
  })
}

// 查询会话详细
export function getSession(id) {
  return request({
    url: '/chat/session/' + id,
    method: 'get'
  })
}

// 新增会话
export function addSession(data) {
  return request({
    url: '/chat/session',
    method: 'post',
    data: data
  })
}

// 修改会话
export function updateSession(data) {
  return request({
    url: '/chat/session',
    method: 'put',
    data: data
  })
}

// 删除会话
export function delSession(id) {
  return request({
    url: '/chat/session/' + id,
    method: 'delete'
  })
}
