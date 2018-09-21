var userApi = Vue.resource("/users{/id}")

function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return false;
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

Vue.component('edit-form', {
    props: ['users', 'editAttr'],
    data: function() {
        return {
            firstName: '',
            lastName: '',
            id: ''
        }
    },
    watch: {
        editAttr: function(newVal, oldVal) {
                this.firstName = newVal ? newVal.firstName : oldVal.firstName;
                this.lastName = newVal ? newVal.lastName : oldVal.lastName;
                this.id = newVal.id;
        }
    },
    template:
        '<form id="demoForm" method="post">' +
        '   <div>' +
        '       <p>First Name and Last Name must be between 5 and 10</p>' +
        '   </div>' +
        '   <div class="btn-group has-error">' +
        '       <input id="firstName" type="text" placeholder="First Name" v-model="firstName"/>' +
        '       <input id="lastName" type="text" placeholder="Last Name" v-model="lastName" />' +
        '       <input class="btn btn-light" type="button" value="Save" @click="save" />' +
        '   </div>' +
        '<div><p style="color: red" id="errorMsg"></p></div>' +
        '</form>',
    methods: {
        save: function() {
            let user = { firstName: this.firstName,lastName: this.lastName };
            let id = getIndex(this.users, this.id);
            let isValid = validationMessage();
            if(isValid) {
                if (id) {
                    userApi.update({id: this.id}, user).then(result => {
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
                    userApi.save({}, user).then(result =>
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
});

Vue.component('user-row', {
    props: ['user', 'users', 'editMethod'],
    template:
        '<tbody>\n' +
        '    <tr>\n' +
        '      <td scope="row">({{ user.id }})</td>\n' +
        '      <td>{{ user.firstName }}</td>\n' +
        '      <td>{{ user.lastName }}</td>\n' +
        '      <td>' +
        '           <div class="btn-group">' +
        '               <input class="btn btn-primary form-control" aria-pressed="true" type="button" value="Edit" @click="edit"/>' +
        '               <input class="btn btn-danger form-control" aria-pressed="true" type="button" value="Delete" @click="del" />' +
        '           </div>' +
        '      </td>\n' +
        '    </tr>\n' +
        '  </tbody>',
    methods: {
        edit: function() {
            this.editMethod(this.user);
        },
        del: function() {
            userApi.remove({id: this.user.id}).then(result => {
                if (result.ok) {
                this.users.splice(this.users.indexOf(this.user), 1);
                }
            })
        }
    }
});

Vue.component('user-list', {
    props: ['users'],
    data () {
        return {
            user: null
        }
    },
    template:
        '<div class="container">' +
            '<edit-form :users="users" :editAttr="user" />' +
            '<table class="table table-bordered">' +
            '<caption>List of users</caption>' +
            '<thead>\n' +
            '    <tr>\n' +
            '      <th scope="col">#</th>\n' +
            '      <th scope="col">First Name</th>\n' +
            '      <th scope="col">Last Name</th>\n' +
            '      <th scope="col">Operation</th>\n' +
            '    </tr>\n' +
            '  </thead>' +
            '<user-row v-for="user in users" :key="user.id" :user="user" ' +
            ' :editMethod="editMethod" :users="users" />' +
            '</table>' +
        '</div>',
    created: function() {
        userApi.get().then(result =>
            result.json().then(data =>
                data.forEach(user => this.users.push(user))
            )
        )
    },
    methods: {
        editMethod: function(user) {
            this.user = user;
        }
    }
});

var app = new Vue ({
    el: '#app',
    template: '<user-list :users="users"/>',
    data: {
        users: []
    }
})

