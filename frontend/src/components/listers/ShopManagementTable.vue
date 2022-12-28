<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="blue"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <ShopManagement :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import ShopManagement from './../ShopManagement.vue';

    export default {
        name: 'ShopManagementManager',
        components: {
            ShopManagement,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "id", value: "id" },
                    { text: "orderNo", value: "orderNo" },
                    { text: "customerId", value: "customerId" },
                    { text: "itemNo", value: "itemNo" },
                    { text: "qty", value: "qty" },
                    { text: "createDate", value: "createDate" },
                    { text: "orderStatus", value: "orderStatus" },
                    { text: "deliveryStatus", value: "deliveryStatus" },
                    { text: "customerAddress", value: "customerAddress" },
                    { text: "shippingAddress", value: "shippingAddress" },
                    { text: "payId", value: "payId" },
                    { text: "customerName", value: "customerName" },
                    { text: "phoneNumber", value: "phoneNumber" },
                    { text: "shopName", value: "shopName" },
                ],
            shopManagement : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/shopmanagements'))
            temp.data._embedded.shopmanagements.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.shopmanagements;

            this.newValue = {
                'orderNo': 0,
                'customerId': '',
                'itemNo': 0,
                'qty': 0,
                'createDate': '2022-12-28',
                'orderStatus': '',
                'deliveryStatus': '',
                'customerAddress': '',
                'shippingAddress': '',
                'payId': 0,
                'customerName': '',
                'phoneNumber': '',
                'shopName': '',
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

