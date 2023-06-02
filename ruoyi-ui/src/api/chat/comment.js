import request from '@/utils/request'

// 查询意见反馈列表
export function listComment(query) {
  return request({
    url: '/chat/comment/list',
    method: 'get',
    params: query
  })
}

// 查询意见反馈详细
export function getComment(id) {
  return request({
    url: '/chat/comment/' + id,
    method: 'get'
  })
}

// 新增意见反馈
export function addComment(data) {
  return request({
    url: '/chat/comment',
    method: 'post',
    data: data
  })
}

// 修改意见反馈
export function updateComment(data) {
  return request({
    url: '/chat/comment',
    method: 'put',
    data: data
  })
}

// 删除意见反馈
export function delComment(id) {
  return request({
    url: '/chat/comment/' + id,
    method: 'delete'
  })
}
