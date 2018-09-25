<template>
    <form id="demoForm" method="post">
       <div>
               <p>First Name and Last Name must be between 5 and 10</p>
           </div>
       <div class="btn-group has-error">
               <input id="firstName" type="text" placeholder="First Name" v-model="firstName"/>
               <input id="lastName" type="text" placeholder="Last Name" v-model="lastName" />
               <input class="btn btn-light" type="button" value="Save" @click="save" />
           </div>
    <div><p style="color: red" id="errorMsg"></p></div>
    </form>
</template>

<script>
    export default {
        name: "edit-form",
        props: ['users', 'editAttr'],
        data() {
            return {
                firstName: '',
                lastName: '',
                id: ''
            }
        },
        watch: {
            editAttr(newVal, oldVal) {
                this.firstName = newVal ? newVal.firstName : oldVal.firstName;
                this.lastName = newVal ? newVal.lastName : oldVal.lastName;
                this.id = newVal.id;
            }
        },
        methods: {
            save() {
                let user = {firstName: this.firstName, lastName: this.lastName};
                let id = getIndex(this.users, this.id);
                let isValid = validationMessage();
                if (isValid) {
                    if (id) {
                        this.$resource("/users{/id}").update({id: this.id}, user).then(result => {
                                result.json().then(data => {
                                    id = getIndex(this.users, data.id);
                                    this.users.splice(id, 1, data);
                                    this.firstName = '';
                                    this.lastName = '';
                                    this.id = '';
                                })
                            }
                        )
                    } else {
                        this.$resource("/users{/id}").save({}, user).then(result =>
                            result.json().then(data => {
                                this.users.push(data);
                                this.firstName = '';
                                this.lastName = '';
                            })
                        )
                    }
                }
            }
        }
    }

    function validationMessage() {
        let fName, lName, text, msg;

        fName = document.getElementById("firstName").value;
        lName = document.getElementById("lastName").value;
        msg = document.getElementById("errorMsg").innerHTML;

        if (fName === "" || fName.length < 4 || fName.length >= 10) {
            text = "First Name is not valid";
            document.getElementById("errorMsg").innerHTML = text;
            return false;
        } else if (lName === "" || lName.length < 4 || lName.length >= 10) {
            text = "Last Name is not valid";
            document.getElementById("errorMsg").innerHTML = text;
            return false;
        }else {
            text = "";
            document.getElementById("errorMsg").innerHTML = text;
            return true;
        }
    }

    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++ ) {
            if (list[i].id === id) {
                return i;
            }
        }
        return false;
    }
</script>

<style scoped>

</style>