import request from '@/utils/request'

// 查询chatgpt秘钥管理列表
export function listKeys(query) {
  return request({
    url: '/chat/keys/list',
    method: 'get',
    params: query
  })
}

// 查询chatgpt秘钥管理详细
export function getKeys(id) {
  return request({
    url: '/chat/keys/' + id,
    method: 'get'
  })
}

// 新增chatgpt秘钥管理
export function addKeys(data) {
  return request({
    url: '/chat/keys',
    method: 'post',
    data: data
  })
}

// 修改chatgpt秘钥管理
export function updateKeys(data) {
  return request({
    url: '/chat/keys',
    method: 'put',
    data: data
  })
}

// 删除chatgpt秘钥管理
export function delKeys(id) {
  return request({
    url: '/chat/keys/' + id,
    method: 'delete'
  })
}
