import request from '@/utils/request'

// 查询充值记录列表
export function listBills(query) {
  return request({
    url: '/chat/bills/list',
    method: 'get',
    params: query
  })
}

// 查询充值记录详细
export function getBills(id) {
  return request({
    url: '/chat/bills/' + id,
    method: 'get'
  })
}

// 新增充值记录
export function addBills(data) {
  return request({
    url: '/chat/bills',
    method: 'post',
    data: data
  })
}

// 修改充值记录
export function updateBills(data) {
  return request({
    url: '/chat/bills',
    method: 'put',
    data: data
  })
}

// 删除充值记录
export function delBills(id) {
  return request({
    url: '/chat/bills/' + id,
    method: 'delete'
  })
}
