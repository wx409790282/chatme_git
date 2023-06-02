import request from '@/utils/request'

// 查询支付秘钥列表
export function listSecrets(query) {
  return request({
    url: '/chat/secrets/list',
    method: 'get',
    params: query
  })
}

// 查询支付秘钥详细
export function getSecrets(id) {
  return request({
    url: '/chat/secrets/' + id,
    method: 'get'
  })
}

// 新增支付秘钥
export function addSecrets(data) {
  return request({
    url: '/chat/secrets',
    method: 'post',
    data: data
  })
}

// 修改支付秘钥
export function updateSecrets(data) {
  return request({
    url: '/chat/secrets',
    method: 'put',
    data: data
  })
}

// 删除支付秘钥
export function delSecrets(id) {
  return request({
    url: '/chat/secrets/' + id,
    method: 'delete'
  })
}
