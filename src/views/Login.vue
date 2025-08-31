<template>
  <div class="login-page">
    <div class="container">
      <h1>Staff Login</h1>
      <div class="login-register-toggle">
        <button @click="showLogin = true" :class="{ active: showLogin }">Login</button>
        <button @click="showLogin = false" :class="{ active: !showLogin }">Register</button>
      </div>
      <form v-if="showLogin" @submit.prevent="login" class="login-form">
        <div class="form-group">
          <label for="name">Name</label>
          <input v-model="name" id="name" type="text" placeholder="Enter Name" />
        </div>
        <div class="form-group">
          <label for="role">Role</label>
          <select v-model="role" id="role">
            <option value="">Select Role</option>
            <option value="Administrator">Administrator</option>
            <option value="Manager">Manager</option>
            <option value="Cashier">Cashier</option>
            <option value="Attendant">Attendant</option>
          </select>
        </div>
        <button type="submit" class="login-btn">Login</button>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      </form>
      <form v-else @submit.prevent="register" class="register-form">
        <div class="form-group">
          <label for="regName">Name</label>
          <input v-model="regName" id="regName" type="text" placeholder="Enter Name" />
        </div>
        <div class="form-group">
          <label for="regRole">Role</label>
          <select v-model="regRole" id="regRole">
            <option value="">Select Role</option>
            <option value="Administrator">Administrator</option>
            <option value="Manager">Manager</option>
            <option value="Cashier">Cashier</option>
            <option value="Attendant">Attendant</option>
          </select>
        </div>
        <button type="submit" class="login-btn">Register</button>
        <div v-if="regErrorMessage" class="error-message">{{ regErrorMessage }}</div>
      </form>
      <div v-if="loggedIn" class="login-summary">
        <h2>Welcome, {{ staff.name }}!</h2>
        <p><strong>Role:</strong> {{ staff.role }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      showLogin: true,
      name: '',
      role: '',
      errorMessage: '',
      regName: '',
      regRole: '',
      regErrorMessage: '',
      loggedIn: false,
      staff: {
        id: '',
        name: '',
        role: ''
      }
    }
  },
  methods: {
    login() {
      this.errorMessage = '';
      if (!this.name || !this.role) {
        this.errorMessage = 'Please fill in all fields.';
        return;
      }
      // Simulate staff login and creation
      this.staff = {
        id: Math.random().toString(36).substr(2, 9),
        name: this.name,
        role: this.role
      };
      this.loggedIn = true;
    },
    register() {
      this.regErrorMessage = '';
      if (!this.regName || !this.regRole) {
        this.regErrorMessage = 'Please fill in all fields.';
        return;
      }
      // Simulate registration (could save to backend)
      this.staff = {
        id: Math.random().toString(36).substr(2, 9),
        name: this.regName,
        role: this.regRole
      };
      this.loggedIn = true;
      this.showLogin = true;
      // Optionally clear registration fields
      this.regName = '';
      this.regRole = '';
    }
  }
}
</script>

<style scoped>
.login-page {
  background: #1a1a1a;
  min-height: 100vh;
  color: white;
  padding: 20px 0;
}

.container {
  max-width: 400px;
  margin: 0 auto;
  padding: 0 20px;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
  color: #ffa500;
}

.login-form, .register-form {
  background: #2a2a2a;
  padding: 25px;
  border-radius: 15px;
  margin-bottom: 30px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 8px;
  color: #ffa500;
}

input, select {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 8px;
  font-size: 1em;
  background: #333;
  color: white;
}

.login-btn {
  background: #4CAF50;
  color: white;
  border: none;
  padding: 12px 25px;
  border-radius: 25px;
  cursor: pointer;
  font-weight: bold;
  transition: background 0.3s;
}

.login-btn:hover {
  background: #45a049;
}

.login-summary {
  background: #222;
  padding: 20px;
  border-radius: 10px;
  color: #fff;
  text-align: center;
}

.error-message {
  color: #ff4d4f;
  background: #fff0f0;
  padding: 10px;
  border-radius: 8px;
  margin-bottom: 15px;
  text-align: center;
}

.login-register-toggle {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.login-register-toggle button {
  background: #333;
  color: #ffa500;
  border: none;
  padding: 10px 30px;
  border-radius: 25px 25px 0 0;
  font-weight: bold;
  cursor: pointer;
  margin: 0 2px;
  transition: background 0.3s;
}

.login-register-toggle button.active {
  background: #ffa500;
  color: #333;
}
</style>
