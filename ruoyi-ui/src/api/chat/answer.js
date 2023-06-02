import request from '@/utils/request'

// 查询问答列表
export function listAnswer(query) {
  return request({
    url: '/chat/answer/list',
    method: 'get',
    params: query
  })
}

// 查询问答详细
export function getAnswer(id) {
  return request({
    url: '/chat/answer/' + id,
    method: 'get'
  })
}

// 新增问答
export function addAnswer(data) {
  return request({
    url: '/chat/answer',
    method: 'post',
    data: data
  })
}

// 修改问答
export function updateAnswer(data) {
  return request({
    url: '/chat/answer',
    method: 'put',
    data: data
  })
}

// 删除问答
export function delAnswer(id) {
  return request({
    url: '/chat/answer/' + id,
    method: 'delete'
  })
}
