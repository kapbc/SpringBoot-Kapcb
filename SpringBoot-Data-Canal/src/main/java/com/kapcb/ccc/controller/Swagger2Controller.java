    @ApiOperation(value = "order", notes = "order测试findById", tags = {"OrderController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "查找Order的id", required = true, dataType = "Long")
    })
    @GetMapping(path = "findById/{id}", produces = "application/json;charset=UTF-8")
    public Result<Order> findById(@PathVariable(value = "id") Long id) {
        log.info("come into order controller's find by id");
        Order order = orderService.findOrderById(id);
        return new Result<>(true, StatusCode.OK, "success", order);
    }
}
