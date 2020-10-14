<template>
    <div class="cp" style="height: 100%;">
        <div class="cl"></div>
        <div class="cr">
            <div class="i t1"></div>
            <div class="i t2"></div>
            <div class="i t3"></div>
            <div class="i t4"></div>
        </div>
    </div>
</template>
<style scoped>
    .cp {
        display:flex;
        overflow-y: auto;
    }
    .cl {
        flex: 0 0 40px;
        background: #f00;
    }
    .cr{
        flex: 1 1 auto;
        display: flex;
        flex-flow: column nowrap;
    }

    .i {
        flex: 0 0 auto;
        display: flex;
        height: 100px;
    }

    .t1 {
        background-color: #333;
    }
    .t2 {
        background-color: #555;
        height: 200px;
    }
    .t3 {
        background-color: #777;
    }
    .t4 {
        background-color: #999;
    }
</style>
