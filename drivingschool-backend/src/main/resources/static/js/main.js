// Main JavaScript file for Driving School Management System

document.addEventListener('DOMContentLoaded', function() {
    // Initialize tooltips
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });

    // Load dashboard statistics
    loadDashboardStats();
    
    // Form validation
    initializeFormValidation();
    
    // Search functionality
    initializeSearch();
});

// Load dashboard statistics
function loadDashboardStats() {
    // This would typically make AJAX calls to REST endpoints
    // For now, we'll simulate with static data
    
    // You can implement REST endpoints later for these statistics
    fetch('/api/stats/customers')
        .then(response => response.json())
        .then(data => {
            document.getElementById('totalCustomers').textContent = data.total || '-';
        })
        .catch(error => {
            console.log('Stats not available yet');
        });
    
    fetch('/api/stats/instructors')
        .then(response => response.json())
        .then(data => {
            document.getElementById('totalInstructors').textContent = data.total || '-';
        })
        .catch(error => {
            console.log('Stats not available yet');
        });
    
    fetch('/api/stats/revenue')
        .then(response => response.json())
        .then(data => {
            document.getElementById('totalRevenue').textContent = '₹' + (data.total || '-');
        })
        .catch(error => {
            console.log('Stats not available yet');
        });
}

// Form validation
function initializeFormValidation() {
    const forms = document.querySelectorAll('.needs-validation');
    
    Array.prototype.slice.call(forms).forEach(function(form) {
        form.addEventListener('submit', function(event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
}

// Search functionality
function initializeSearch() {
    const searchInput = document.getElementById('searchInput');
    if (searchInput) {
        searchInput.addEventListener('input', function() {
            const searchTerm = this.value.toLowerCase();
            const rows = document.querySelectorAll('tbody tr');
            
            rows.forEach(function(row) {
                const text = row.textContent.toLowerCase();
                if (text.includes(searchTerm)) {
                    row.style.display = '';
                } else {
                    row.style.display = 'none';
                }
            });
        });
    }
}

// Utility functions
function showAlert(message, type = 'info') {
    const alertDiv = document.createElement('div');
    alertDiv.className = `alert alert-${type} alert-dismissible fade show`;
    alertDiv.innerHTML = `
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    `;
    
    const container = document.querySelector('.container');
    if (container) {
        container.insertBefore(alertDiv, container.firstChild);
        
        // Auto-dismiss after 5 seconds
        setTimeout(function() {
            alertDiv.remove();
        }, 5000);
    }
}

// Confirm delete action
function confirmDelete(itemName, deleteUrl) {
    if (confirm(`Are you sure you want to delete ${itemName}? This action cannot be undone.`)) {
        window.location.href = deleteUrl;
    }
}

// Format currency
function formatCurrency(amount) {
    return new Intl.NumberFormat('en-IN', {
        style: 'currency',
        currency: 'INR',
        minimumFractionDigits: 0,
        maximumFractionDigits: 0
    }).format(amount);
}

// Format date
function formatDate(dateString) {
    const options = { year: 'numeric', month: 'short', day: 'numeric' };
    return new Date(dateString).toLocaleDateString('en-IN', options);
}

// Loading state management
function showLoading(element) {
    const originalText = element.textContent;
    element.innerHTML = '<span class="loading"></span> Loading...';
    element.disabled = true;
    return originalText;
}

function hideLoading(element, originalText) {
    element.textContent = originalText;
    element.disabled = false;
}