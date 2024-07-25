import {createApp, computed, ref} from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';
import {Axios} from 'https://unpkg.com/axios@1.7.2/dist/esm/axios.min.js';

createApp({
    setup() {
        const data = async () => {
            await Axios.get("http://localhost:8080/cart/1")
                .then(consol);
        };

        //商品假資料
        const item = {
            checked: false,
            picture: "圖片",
            productName: "巧克力餅乾",
            price: 100,
            amount: 1,
            // total: this.price * this.amount
        };
        const itemTwo = {
            checked: false,
            picture: "圖片",
            productName: "牛奶糖餅乾",
            price: 200,
            amount: 2,
            // total: this.price * this.amount
        };
        const itemThree = {
            checked: false,
            picture: "圖片",
            productName: "白巧克力餅乾",
            price: 300,
            amount: 3,
            // total: this.price * this.amount
        };

        const items = ref([item, itemTwo, itemThree]);

        //計算屬性: 為使前端頁面更新計算結果, 需使用computed()
        const sum = computed(() => {
            let sum = 0;
            for (let i = 0; i < items.value.length; i++) {
                const subTotal = items.value[i].price * items.value[i].amount;
                sum = sum + subTotal;
            }
            return sum;
        })

        //刪除商品
        const deleteItem = () => {
        };

        return {

            items,
            sum,
            deleteItem
        }
    }
}).mount('#shopping-cart');
