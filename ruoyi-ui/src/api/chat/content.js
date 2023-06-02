import request from '@/utils/request'

// 查询提示词列表
export function listContent(query) {
  return request({
    url: '/chat/content/list',
    method: 'get',
    params: query
  })
}

// 查询提示词详细
export function getContent(id) {
  return request({
    url: '/chat/content/' + id,
    method: 'get'
  })
}

// 新增提示词
export function addContent(data) {
  return request({
    url: '/chat/content',
    method: 'post',
    data: data
  })
}

// 修改提示词
export function updateContent(data) {
  return request({
    url: '/chat/content',
    method: 'put',
    data: data
  })
}

// 删除提示词
export function delContent(id) {
  return request({
    url: '/chat/content/' + id,
    method: 'delete'
  })
}
