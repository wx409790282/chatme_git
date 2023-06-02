import request from '@/utils/request'

// 查询商品类型列表
export function listPayment(query) {
  return request({
    url: '/chat/payment/list',
    method: 'get',
    params: query
  })
}

// 查询商品类型详细
export function getPayment(id) {
  return request({
    url: '/chat/payment/' + id,
    method: 'get'
  })
}

// 新增商品类型
export function addPayment(data) {
  return request({
    url: '/chat/payment',
    method: 'post',
    data: data
  })
}

// 修改商品类型
export function updatePayment(data) {
  return request({
    url: '/chat/payment',
    method: 'put',
    data: data
  })
}

// 删除商品类型
export function delPayment(id) {
  return request({
    url: '/chat/payment/' + id,
    method: 'delete'
  })
}
