import request from '@/utils/request'

// 查询礼包兑换码列表
export function listCharge(query) {
  return request({
    url: '/chat/charge/list',
    method: 'get',
    params: query
  })
}

// 查询礼包兑换码详细
export function getCharge(id) {
  return request({
    url: '/chat/charge/' + id,
    method: 'get'
  })
}

// 新增礼包兑换码
export function addCharge(data) {
  return request({
    url: '/chat/charge',
    method: 'post',
    data: data
  })
}

// 修改礼包兑换码
export function updateCharge(data) {
  return request({
    url: '/chat/charge',
    method: 'put',
    data: data
  })
}

// 删除礼包兑换码
export function delCharge(id) {
  return request({
    url: '/chat/charge/' + id,
    method: 'delete'
  })
}
